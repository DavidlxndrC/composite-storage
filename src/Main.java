public class Main {
    public static void main(String[] args) {
        // Se construye el árbol dependiendo de la abstracción Container
        IContainer root = new Folder("root");

        IContainer docs = new Folder("docs");
        docs.addStorageUnit(new File("cv.pdf", 120));
        docs.addStorageUnit(new File("tesis.docx", 800));

        IContainer vacaciones = new Folder("vacaciones");
        vacaciones.addStorageUnit(new File("playa.jpg", 2500));
        vacaciones.addStorageUnit(new File("montana.jpg", 3100));

        IContainer fotos = new Folder("fotos");
        fotos.addStorageUnit(new File("foto.jpg", 100));
        fotos.addStorageUnit(vacaciones);

        root.addStorageUnit(docs);
        root.addStorageUnit(fotos);
        root.addStorageUnit(new File("notas.txt", 5));

        // 1. Listado recursivo
        System.out.println("=== Estructura ===");
        root.display();

        // 2. Tamaño total
        System.out.println("\nTamaño total de root: " + root.getSize() + " KB");

        // El caso de estudio
        IStorageUnit s = new File("foto.jpg", 100);
        // s.addStorageUnit(new File("otra.jpg", 50));
        // No complia "cannot find symbol: method addStorageUnit(File)"
        // El error se detecta en compilación, no en ejecución

        // Si un cliente solo tiene un StorageUnit y quiere agregar, debe preguntar:
        if (s instanceof IContainer c) {
            c.addStorageUnit(new File("otra.jpg", 50));
        } else {
            System.out.println("\n'" + s.getName() + "' no es un contenedor: no se puede agregar.");
        }
    }
}