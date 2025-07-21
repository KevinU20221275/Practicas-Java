package composite;

public class EjemploComposite {
    public static void main(String[] args) {
        Directorio doc = new Directorio("Documentos");
        Directorio java = new Directorio("Java");

        java.addComponent(new Archivo("patron-composite.docx"));

        Directorio stream = new Directorio("Api Stream");

        stream.addComponent(new Archivo("stream-map.docx"));

        java.addComponent(stream);

        doc.addComponent(java);
        doc.addComponent(new Archivo("cv.docx"));
        doc.addComponent(new Archivo("logo.jpeg"));

        System.out.println(doc.mostrar(0));
    }
}
