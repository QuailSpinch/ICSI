from array import array
import random
arrayval = array('i')

class Node:
    #constructor of a node (Root, node, or leaf!)
    def __init__(self, key):
        self.key = key
        self.rightnode = None
        self.leftnode = None
    
    #insert a node
    def insert(self, key):
        if self.key: #this is a node with a key
            if key < self.key: #input value less than the node - goes to left
                if self.leftnode is None: #node doesn't exist here, so set this value to the node
                    self.leftnode = Node(key)
                else:
                    self.leftnode.insert(key) #node already exists, send back to top
            elif key > self.key: #input value greater than the node - goes to right
                if self.rightnode is None:
                    self.rightnode = Node(key)
                else:
                    self.rightnode.insert(key)
        else: #node doesn't exist here, make new one (For the root node)
            self.rightnode = None
            self.leftnode = None
            self.key = key

    #get values from a spot in tree and turn them into an array
    def toarray(self):
        if self.leftnode: #node exists here, call toarray on it
            self.leftnode.toarray()
        if self.rightnode:
            self.rightnode.toarray()
        arrayval.insert(0, self.key) #insert the key value to the key

    #removes all nodes from this point down
    def delete(self):
        if self.rightnode: #node exists, call delete on it
            self.rightnode.delete()
        if self.leftnode:
            self.leftnode.delete()
        self.key = None #remove the key value, erasing the node


    #delete a node
    def deletenode(self, key):
        if key > self.key: #value of node to delete is greater than current node
            if self.rightnode is None: #no node exists here, node not found
                print("Node not found to delete!")
            else: #Node is here, run deletenode with the same key on this node
                self.rightnode.deletenode(key)
        elif key < self.key: #Value of node to delete is less than current node
            if self.leftnode is None:
                print("Node not found to delete!")
            else:
                self.leftnode.deletenode(key)
        else: #value of node to delete is the same as the current node
            self.toarray() #create an array from this node down
            arrayval.remove(self.key) #remove this node's value from the node
            self.delete() #delete this node (and all following)
            for x in arrayval: #put all the following nodes back onto the list
                root.insert(x)
    
    #print the tree
    def printtree(self, count):
        printval = "{val}" 
        tab = "" #used for indenting levels of the tree
        if count == 0: #if top level (label as root and print without newline)
            print("Root: ", end='')
        print(printval.format(val = self.key)) #print the key of the node
        count += 1 # incrememnt the count for indentation
        for x in range(count): #put's count number of tabs on tab string
            tab = tab + "\t"
        if self.rightnode: #if a rightnode exists, print its label and call printtree on it
            print(tab + "Right Node: ", end='')
            self.rightnode.printtree(count)
        if self.leftnode: #if a leftnode exists, print its label and call printtree on it
            print(tab + "Left Node: ", end='')
            self.leftnode.printtree(count)

#main
arrayPop = array('i') #array for populating the tree, integers of size 2 bytes
for x in range (20):
    arrayPop.append((int(random.uniform(1, 100)))) #add 20 random integers between 1-100
root = Node(arrayPop[0]) #first value in array is the root
arrayPop.remove(arrayPop[0]) #remove first value to not get a double
for x in arrayPop: #insert the remaining 19 values
    root.insert(x)
print("Printing original random tree: ")
root.printtree(0) #print the tree
print("Enter a node to delete: ", end='')
delval = int(input()) #read in a value to delete a specific node
root.deletenode(delval) #delete the node
print("Printing tree with deleted node: ")
root.printtree(0)
print("Adding in a new random node: ")
root.insert(int(random.uniform(1, 100))) #inserts a new random value 1-100
root.printtree(0)