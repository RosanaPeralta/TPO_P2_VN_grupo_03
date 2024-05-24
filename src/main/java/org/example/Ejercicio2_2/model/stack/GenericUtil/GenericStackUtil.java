package org.example.Ejercicio2_2.model.stack.GenericUtil;

import org.example.Ejercicio2_2.model.stack.GenericInterfaces.IGenericStack;
import org.example.Ejercicio2_2.model.stack.GenericStack;

public class GenericStackUtil<E> {

    public GenericStack<E> invert(IGenericStack<E> stack){
        GenericStack<E> copy = copy(stack);
        GenericStack<E> invertedStack = new GenericStack<>();
        while(!copy.isEmpty()){
            invertedStack.add(copy.getTop());
            copy.remove();
        }
        return invertedStack;
    }

    public GenericStack<E> copy(IGenericStack<E> originalStack){
        GenericStack<E> aux1 = new GenericStack<>();
        GenericStack<E> aux2 = new GenericStack<>();

        while (!originalStack.isEmpty()){
            aux1.add(originalStack.getTop());
            aux2.add(originalStack.getTop());
            originalStack.remove();
        }
        while (!aux1.isEmpty()){
            originalStack.add(aux1.getTop());
            aux1.remove();
        }
        while(!aux2.isEmpty()){
            aux1.add(aux2.getTop());
            aux2.remove();
        }
        return aux1;
    }
}
