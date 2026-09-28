# composite-storage

Patrón Composite en Java para modelar Folders y Archivos.

- "StorageUnit": interfaz base (getName, getSize, display)
- "Container": interfaz para unidades que contienen otras (addStorageUnit)
- "File": hoja
- "Folder": compuesto