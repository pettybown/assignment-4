class MyTestingClass{
    private int val;
    public MyTestingClass(int v) {
        this.val = v;
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(val);
    }
}