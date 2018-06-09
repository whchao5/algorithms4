package BagsQueuesStacks;

/**
 * Created by HJKLI on 2016/9/1.
 */
public class Ex_12_Stack_copy<Item> {

    public void copy(Stacks<Item> Data, Stacks<Item> copyData) {
        for (Item s : Data)
            copyData.push(s);
    }
}
