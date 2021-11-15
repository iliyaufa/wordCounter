package domain;

class Word {
    private String value;
    private int counter;

    public Word(String s) {
        this.value= s;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Word{" +
                "value='" + value + '\'' +
                ", counter=" + counter +
                '}';
    }
}
