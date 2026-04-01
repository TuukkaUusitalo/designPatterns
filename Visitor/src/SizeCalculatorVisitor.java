public class SizeCalculatorVisitor implements FileSystemVisitor {

    private int totalSize = 0;

    public int getTotalSize() {
        return totalSize;
    }

    @Override
    public void visit(File file) {
        totalSize += file.getSizeMb();
    }

    @Override
    public void visit(Directory dir) {
        // nothing needed
    }
}