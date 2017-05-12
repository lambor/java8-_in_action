package ch14;

/**
 * Created by lambor on 17-5-12.
 */
public class Tree_14_2 {
    static class Tree {
        private String key;
        private int val;
        private Tree left,right;

        public Tree(String key, int val, Tree left, Tree right) {
            this.key = key;
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class TreeProcessor {
        public static int lookup(String k,int defaultval,Tree t) {
            if(t == null) return defaultval;
            if(k.equals(t.key)) return t.val;
            return lookup(k,defaultval,k.compareTo(t.key)<0?t.left:t.right);
        }

        public static void update(String k,int newval,Tree t) {
            if(t == null) t = new Tree(k,newval,null,null);
            if(k.equals(t.key)) t.val = newval;
            update(k,newval,k.compareTo(t.key)<0?t.left:t.right);
        }

        public static Tree fupdate(String k,int newval,Tree t) {
            return t == null?
                    new Tree(k,newval,null,null):
                    k.equals(t.key)?
                            new Tree(k,newval,t.left,t.right):
                            k.compareTo(t.key)<0?
                                    new Tree(t.key,t.val,fupdate(k,newval,t.left),t.right):
                                    new Tree(t.key,t.val,t.left,fupdate(k,newval,t.right));
        }
    }
}
