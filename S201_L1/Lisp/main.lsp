(defun process-element (x)
  (if (>= x 4)
      (* x 2)  
      (/ x 2))) 

(let* ((list1 '(1 2 3))
       (list2 '(4 5 6))
       (processed-list1 (mapcar #'process-element list1))
       (processed-list2 (mapcar #'process-element list2))
       (combined-list (append processed-list1 processed-list2)))
  (format t "Lista final: ~a~%" combined-list)
  combined-list)