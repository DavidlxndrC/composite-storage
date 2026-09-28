// Abstracción para unidades que pueden contener otras unidades
// Extiende StorageUnit: un contenedor sigue siendo tratable como una unidad
public interface IContainer extends IStorageUnit {
    void addStorageUnit(IStorageUnit unit);
}