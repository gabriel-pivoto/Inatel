import pulp
import tkinter as tk
from tkinter import ttk, messagebox


# Função para resolver o problema
def solve_ppl():
    try:
        # Número de variáveis e restrições selecionados
        num_vars = int(variables_count.get())
        num_restr = int(restrictions_count.get())

        # Obter coeficientes da função objetivo
        coeff_obj = [float(entry_coeff_obj[i].get()) for i in range(num_vars)]

        # Obter coeficientes e limites das restrições
        coeff_constraints = []
        rhs_constraints = []
        for i in range(num_restr):
            coeff_constraints.append([float(entry_coeff_constraints[i][j].get()) for j in range(num_vars)])
            rhs_constraints.append(float(entry_rhs_constraints[i].get()))

        # Criar o modelo
        global model, variables
        model = pulp.LpProblem("Maximizar_Lucro", pulp.LpMaximize)

        # Criar variáveis de decisão
        variables = [pulp.LpVariable(f"x{i+1}", lowBound=0, cat="Continuous") for i in range(num_vars)]

        # Adicionar a função objetivo
        model += pulp.lpSum(coeff_obj[i] * variables[i] for i in range(num_vars)), "Função_Objetivo"

        # Adicionar as restrições
        for i in range(num_restr):
            model += pulp.lpSum(coeff_constraints[i][j] * variables[j] for j in range(num_vars)) <= rhs_constraints[i], f"Restrição_{i+1}"

        # Resolver o modelo
        model.solve()

        # Exibir os resultados
        if model.status == pulp.LpStatusOptimal:
            result = f"Lucro Máximo: {pulp.value(model.objective):.2f}\n"
            for i, var in enumerate(variables):
                result += f"x{i+1}: {var.varValue:.2f}\n"
            # Adicionar preço sombra
            result += "\nPreços Sombra das Restrições:\n"
            for name, constraint in model.constraints.items():
                result += f"{name}: {constraint.pi:.2f}\n"
            result_text.set(result)
            # Mostrar botão e área para condições de viabilidade
            viability_frame.grid(row=5, column=0, pady=10, sticky="NSEW")
        else:
            result_text.set("Não foi possível encontrar uma solução ótima.")
    except Exception as e:
        messagebox.showerror("Erro", str(e))


# Atualizar os campos dinamicamente com base nas escolhas
def update_entries():
    # Limpar campos existentes
    for widget in inputs_frame.winfo_children():
        widget.destroy()

    # Número de variáveis e restrições
    num_vars = int(variables_count.get())
    num_restr = int(restrictions_count.get())

    # Labels e Entradas da Função Objetivo
    ttk.Label(inputs_frame, text="Coeficientes da Função Objetivo", font=("Arial", 10, "bold")).grid(row=0, column=0, columnspan=num_vars, pady=5)
    global entry_coeff_obj
    entry_coeff_obj = [ttk.Entry(inputs_frame, width=12) for _ in range(num_vars)]
    for i, entry in enumerate(entry_coeff_obj):
        ttk.Label(inputs_frame, text=f"c{i+1}", anchor="center").grid(row=1, column=i, pady=5, padx=5)
        entry.grid(row=2, column=i, pady=5, padx=5)

    # Labels e Entradas das Restrições
    ttk.Label(inputs_frame, text="Coeficientes das Restrições", font=("Arial", 10, "bold")).grid(row=3, column=0, columnspan=num_vars + 1, pady=10)
    global entry_coeff_constraints, entry_rhs_constraints
    entry_coeff_constraints = [[ttk.Entry(inputs_frame, width=12) for _ in range(num_vars)] for _ in range(num_restr)]
    entry_rhs_constraints = [ttk.Entry(inputs_frame, width=12) for _ in range(num_restr)]
    for i in range(num_restr):
        for j in range(num_vars):
            ttk.Label(inputs_frame, text=f"a{i+1}{j+1}", anchor="center").grid(row=4 + 2 * i, column=j, pady=5, padx=5)
            entry_coeff_constraints[i][j].grid(row=5 + 2 * i, column=j, pady=5, padx=5)
        ttk.Label(inputs_frame, text=f"b{i+1} (≤)", anchor="center").grid(row=4 + 2 * i, column=num_vars, pady=5, padx=5)
        entry_rhs_constraints[i].grid(row=5 + 2 * i, column=num_vars, pady=5, padx=5)


# Aplicar novas condições de viabilidade
def apply_viability_conditions():
    try:
        new_rhs = [float(entry_new_rhs[i].get()) for i in range(len(entry_new_rhs))]
        for i, value in enumerate(new_rhs):
            model.constraints[f"Restrição_{i+1}"].changeRHS(value)
        model.solve()

        if model.status == pulp.LpStatusOptimal:
            result = f"Novo Lucro Máximo: {pulp.value(model.objective):.2f}\n"
            for i, var in enumerate(variables):
                result += f"x{i+1}: {var.varValue:.2f}\n"
            result_text.set(result)
        else:
            result_text.set("Novo problema não é viável.")
    except Exception as e:
        messagebox.showerror("Erro", str(e))


# Interface Gráfica (Tkinter)
root = tk.Tk()
root.title("Resolução de PPL - Simplex")

# Frame principal com Canvas e Scrollbar
canvas = tk.Canvas(root)
scrollbar = ttk.Scrollbar(root, orient="vertical", command=canvas.yview)
scrollable_frame = ttk.Frame(canvas)

# Configurar o Canvas para rolagem
scrollable_frame.bind(
    "<Configure>",
    lambda e: canvas.configure(scrollregion=canvas.bbox("all"))
)
canvas.create_window((0, 0), window=scrollable_frame, anchor="nw")
canvas.configure(yscrollcommand=scrollbar.set)

canvas.pack(side="left", fill="both", expand=True)
scrollbar.pack(side="right", fill="y")

# Frame principal dentro do Canvas
main_frame = ttk.Frame(scrollable_frame, padding="10")
main_frame.grid(row=0, column=0, sticky="NSEW")

# Seleção de número de variáveis e restrições
selection_frame = ttk.LabelFrame(main_frame, text="Configurações do Problema", padding="10")
selection_frame.grid(row=0, column=0, pady=10, sticky="NSEW")
ttk.Label(selection_frame, text="Número de Variáveis:").grid(row=0, column=0, padx=5, pady=5)
variables_count = ttk.Combobox(selection_frame, values=[2, 3, 4], width=5, state="readonly")
variables_count.set(2)
variables_count.grid(row=0, column=1, padx=5, pady=5)

ttk.Label(selection_frame, text="Número de Restrições:").grid(row=1, column=0, padx=5, pady=5)
restrictions_count = ttk.Entry(selection_frame, width=5)
restrictions_count.insert(0, "2")
restrictions_count.grid(row=1, column=1, padx=5, pady=5)

ttk.Button(selection_frame, text="Atualizar Entradas", command=update_entries).grid(row=2, column=0, columnspan=2, pady=10)

# Frame para os inputs
inputs_frame = ttk.LabelFrame(main_frame, text="Entradas do Problema", padding="10")
inputs_frame.grid(row=1, column=0, pady=10, sticky="NSEW")

# Resultado
ttk.Label(main_frame, text="Resultado", font=("Arial", 10, "bold")).grid(row=2, column=0, pady=5)
result_text = tk.StringVar()
ttk.Label(main_frame, textvariable=result_text, foreground="green", anchor="w").grid(row=3, column=0, pady=10)

# Botão para resolver o problema
ttk.Button(main_frame, text="Resolver Problema", command=solve_ppl).grid(row=4, column=0, pady=10)

# Frame para novas condições de viabilidade
viability_frame = ttk.LabelFrame(main_frame, text="Novas Condições de Viabilidade", padding="10")
global entry_new_rhs
entry_new_rhs = []
ttk.Label(viability_frame, text="Novos Limites das Restrições (b)").grid(row=0, column=0, pady=5, sticky="W")

# Entradas para condições de viabilidade
entry_new_rhs = [ttk.Entry(viability_frame, width=12) for _ in range(2)]  # Atualizar dinamicamente conforme o problema
for i, entry in enumerate(entry_new_rhs):
    entry.grid(row=1 + i, column=0, pady=5, padx=5)

# Botão para aplicar novas condições
ttk.Button(viability_frame, text="Aplicar Novas Condições", command=apply_viability_conditions).grid(row=3, column=0, pady=10)

# Inicializar entradas padrão
update_entries()

root.mainloop()
