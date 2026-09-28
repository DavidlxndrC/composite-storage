public interface IStorageUnit {
    String getName();

    // Tamaño en KB
    long getSize();

    // Muestra la unidad; 'indent' controla la sangría según la profundidad
    void display(String indent);

    // Conveniencia: inicia el despliegue sin sangría
    default void display() {
        display("");
    }
}