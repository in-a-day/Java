package cc.margay.pattern.singleton;

public class SingletonPattern {
    public static void main(String[] args) {
        Resource r1 = Singleton.getResource();
        Resource r2 = Singleton.getResource();
        System.out.println(r1.getVal());
        r1.setVal(1);
        System.out.println(r2.getVal());
    }
}

interface Resource {
    int getVal();

    void setVal(int i);
}

class Singleton {
    private static final class ResourceImpl implements Resource {
        private int i;
        private ResourceImpl(int i) {
            this.i = i;
        }

        @Override
        public synchronized int getVal() {
            return i;
        }

        @Override
        public synchronized void setVal(int i) {
            this.i = i;
        }
    }

    private static class ResourceHolder {
        private static Resource resource = new ResourceImpl(2);
    }

    public static Resource getResource() {
        return ResourceHolder.resource;
    }
}
