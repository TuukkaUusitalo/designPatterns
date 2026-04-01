public class File implements FileSystemElement {

    private final String name;
    private final int sizeMb;

    public File(String name, int sizeMb) {
        this.name = name;
        this.sizeMb = sizeMb;
    }

    public String getName() {
        return name;
    }

    public int getSizeMb() {
        return sizeMb;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
