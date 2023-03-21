import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CreateStructure {
    private static final String DOT = ".";
    private Folder root = new Folder("root");
    private final UserInput userInput = new UserInput();
    private boolean isStop = false;

    private ArrayList<Data> getStructureArray(ArrayList<String> arrayList) {
        ArrayList<Data> dataList = new ArrayList<>();
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i).contains(DOT)) {
                dataList.add(new File(arrayList.get(i)));
            } else {
                dataList.add(new Folder(arrayList.get(i)));
            }
        }
        return dataList;
    }

    public void structuring() {
        while (!isStop) {
            Folder currentFolder = root;
            String[] arrayInput = userInput.getTextArray();
            ArrayList<Data> dataList = getStructureArray(new ArrayList<>(Arrays.asList(arrayInput)));
            validation(arrayInput[0]);
            for (Data data : dataList) {
                if (data.getClass() == Folder.class && currentFolder.contains(data)) {
                    currentFolder = currentFolder.getNewCurrentFolder((Folder) data);
                } else {
                    currentFolder.addToFolder(data);
                    if (data.getClass() == Folder.class) {
                        currentFolder = currentFolder.getNewCurrentFolder((Folder) data);
                    }
                }
            }
            root.print();
        }
    }

    private void saving(){
        try (ObjectOutputStream saveStream = new ObjectOutputStream(
                new FileOutputStream("save.bin")
        )) {
            saveStream.writeObject(root);
            System.out.println("Save is done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Folder getSave(){
        Folder oldSave = null;
        try(ObjectInputStream objectInputStream =
                    new ObjectInputStream(new FileInputStream("save.bin"))){
            oldSave = (Folder) objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return oldSave;
    }

    private void validation (String string){
        switch (string) {
            case "stop":
                isStop = true;
                break;
            case "save":
                saving();
                System.out.println("save is done.");
                break;
            case "load":
                root = getSave();
                System.out.println("Save load is done.");
                System.out.println();
                break;
        }
    }
}
