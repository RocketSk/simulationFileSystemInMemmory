import java.io.Serializable;
import java.util.Objects;

public class File implements Data, Serializable {
    static final long serialVersionUID = 1;
    private final String name;
    private String ident = "    ";

    public File(String name) {
        this.name = name;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return name.equals(file.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public void print() {
        System.out.println(ident + name);
    }

}
