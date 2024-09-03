fn preenche_arr(arr: &mut [i32], x: i32) {
    for i in 0..arr.len() {
        arr[i] = (i as i32) * x;
    }
}

fn main() {
    let mut arr = [0; 10]; 
    let number_cvt = 5; 

    preenche_arr(&mut arr, number_cvt);

    println!("Array preenchido: {:?}", arr);
}
