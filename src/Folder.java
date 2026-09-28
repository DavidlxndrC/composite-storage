import java.util.ArrayList;
import java.util.List;

public class Folder implements IContainer {
    private final String name;
    private final List<IStorageUnit> children = new ArrayList<>();

    public Folder(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser vacío");
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addStorageUnit(IStorageUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("La unidad no puede ser null");
        }
        if (unit == this) {
            throw new IllegalArgumentException("Un folder no puede contenerse a sí mismo");
        }
        children.add(unit);
    }

    // Caso recursivo: suma el tamaño de cada hijo (sea File o Folder)
    @Override
    public long getSize() {
        long total = 0;
        for (IStorageUnit child : children) {
            total += child.getSize();
        }
        return total;
    }

    // Caso recursivo: se muestra a sí mismo y delega en los hijos
    @Override
    public void display(String indent) {
        System.out.println(indent + "+ " + name + "/ (" + getSize() + " KB)");
        for (IStorageUnit child : children) {
            child.display(indent + "    ");
        }
    }
}