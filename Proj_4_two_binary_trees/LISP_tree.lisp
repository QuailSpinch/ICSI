(defvar savelist) ;used for saving values
(defvar randArray) ;array that the BST is built from
(defvar randState) ;seed of the random
(defvar i) ;iteration
(defvar dval) ;value to delete, read from user

(defstruct node ;what a node has
  key
  rightnode
  leftnode
)

(defstruct root ;special for the root
  key
  rightnode
  leftnode
)

(defvar treeroot (make-root)) ;create the basis for the bst, attributes set to nil
(setf (root-key treeroot) nil)
(setf (root-leftnode treeroot) nil)
(setf (root-rightnode treeroot) nil)

;for inserting a nodes
(defun insert (n val)
  (if (typep n 'node) ;as long as n is a node
      (if (typep (node-key n) 'integer) ;if the key is an integer (if it exists)
          (if (< val (node-key n)) ;if the val is less than the node
              (if (typep (node-leftnode n) 'node) ;if the leftnode exists
                  (insert (node-leftnode n) val) ;run inset on the leftnode with the same val
                (setf (node-leftnode n) (make-node :key val)) ;else, make the val the (left)node here
              )
            ;else: the val is greater than the node (or equal)
            (if (typep (node-rightnode n) 'node) ;if rightnode exists
                (insert (node-rightnode n) val)
              (setf (node-rightnode n) (make-node :key val))
            )
          )
        (setf (node-key n) val) ;node n doesn't have a key, set val to its key
      )
  )
    ;For when n is the root node, same as above except root accessors instead of node
  (if (typep n 'root)
    (if (typep (root-key n) 'integer)
        (if (< val (root-key n))
            (if (typep (root-leftnode n) 'node)
                (insert (root-leftnode n) val)
              (setf (root-leftnode n) (make-node :key val))
            )
          (if (typep (root-rightnode n) 'node)
              (insert (root-rightnode n) val)
            (setf (root-rightnode n) (make-node :key val))
          )
        )
      (setf (root-key n) val)
    )
  )
)

(defun tolist (n) ;make a list of values to save and put back after the deletion of a node
  (if (typep (node-leftnode n) 'node) ;if a leftnode exists, call tolist on it
      (tolist (node-leftnode n))
  )
  (if (typep (node-rightnode n) 'node) ;if a rightnode exists, call tolist on it
      (tolist (node-rightnode n))
  )
  (if (typep (node-key n) 'integer) ;if this node's key is an int, push it on the list
    (push (node-key n) savelist)
  )
)

(defun deletecascade (n) ;delete from first node all the way to the leaves
  (if (typep (node-rightnode n) 'node) ;if a leftnode exists, call deletecascade on it
    (deletecascade (node-rightnode n))
  )
  (if (typep (node-leftnode n) 'node) ;if a righttnode exists, call deletecascade on it
    (deletecascade (node-leftnode n))
  )
  ;set all the nodes values to nil (it is deleted)
  (setf (node-key n) nil)
  (setf (node-leftnode n) nil)
  (setf (node-rightnode n) nil)
)

(defun deletenode (n val)
  (if (typep n 'node) ;as long as n is a node
      (if (> val (node-key n)) ;val of node to delete is greater than this node, go to rightnode
        (if (typep (node-rightnode n) 'node) ;if rightnode exists run deletenode on it
            (deletenode (node-rightnode n) val)
          (write "Node not found for deleting!") ;else, print node not founs
        )
      )
    ; n is a root
    (if (> val (root-key n)) ;val of node to delete is greater than this node, go to rightnode
      (if (typep (root-rightnode n) 'node) ;if rightnode exists run deletenode on it
          (deletenode (root-rightnode n) val)
        (write "Node not found for deleting!") ;else, print node not founs
      )
    )
  )
  (if (typep n 'node)
      (if (< val (node-key n)) ;val of node to delete is less than this node, go to leftnode
        (if (typep (node-leftnode n) 'node)
            (deletenode (node-leftnode n) val)
          (write "Node not found for deleting!")
        )
      )
    ;n is a root
    (if (< val (root-key n)) ;val of node to delete is less than this node, go to leftnode
      (if (typep (root-leftnode n) 'node)
          (deletenode (root-leftnode n) val)
        (write "Node not found for deleting!")
      )
    )
  )
  (if (typep n 'node)
    (if (equal val (node-key n)) ;val of node to delete is equal to this node
      (progn
        (tolist n) ;send this node tolist
        (setq savelist (cdr savelist)) ; remove first item (the node being deleted)
        (deletecascade n) ;delete cascade from this node (values removed from tree)
        (loop for x in savelist ;reinsert the values after this node back onto the tree
          do (if (typep x 'integer)
              (insert treeroot x)
             )
        )
      )
    )
  )
)

(setq savelist (list ())) ;make the list a list
(setf randArray (make-array '(20))) ;makes the array size 20
(setf randState (make-random-state t)) ;seeds random
(setf i 0)
(loop ;itterates through and fills array with random ints
  (setf (aref randArray i) (+ 1 (random 100))) ;add a random number to the array
  (setf i (+ i 1)) ;increment
  (when (> i 19) (return randArray)) ;randarray has 20 elements
)
(loop for x from 0 to 19 ;insert all 20 values to the tree
  do (insert treeroot (aref randarray x)))

(write-line "Printing original random tree: ")
(write treeroot)
(terpri)
(write "Enter key value of node to delete: ")
(setq dval (read)) ;get a value of a node-key from the user to delete
(terpri)
(write-line "Printing deleted node tree:")
(deletenode treeroot dval)
(write treeroot)
(terpri)
(write-line "Adding in a new random node:" )
(insert treeroot (+ 1 (random 100))) ;add a random number to the tree
(write treeroot)
