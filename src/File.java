public class File implements IStorageUnit {
    private final String name;
    private final long size;

    public File(String name, long size) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser vacío");
        }
        if (size < 0) {
            throw new IllegalArgumentException("El tamaño no puede ser negativo");
        }
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getSize() {
        return size;
    }

    // Caso base de la recursión
    @Override
    public void display(String indent) {
        System.out.println(indent + "- " + name + " (" + size + " KB)");
    }
}