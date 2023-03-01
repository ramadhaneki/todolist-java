public class AplikasiTodoList {

    public static String[] model = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {

        viewShowTodo();
    }

    /**
     * Menampilkan todolist
     */
    public static void showTodo(){
        System.out.println("TODOLIST");
        for (var i = 0; i < model.length; i++){
            var todo = model[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodo(){
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi Kasus Java Dasar";
        showTodo();
    }

    /**
     * Menambahkan todolist
     */
    public static void addTodo(String todo){
        // cek apakah model penuh
        var full = true;
        for (int i = 0; i < model.length; i++){
            if (model[i] == null){
                // model masih ada yang kosong
                full = false;
                break;
            }
        }

        // Jika model penuh, model akan di resize 2xlipat
        if(full){
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // ke array yang null
        for (var i = 0; i < model.length; i++){
            if(model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodo(){
        for (int i = 0; i < 25; i++) {
            addTodo("Contoh todo ke. " + i);
        }
     showTodo();
    }
    /**
     * menghapush todolist
     */
    public static boolean deleteTodo(Integer number){
        if((number - 1) >= model.length){
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length) - 1) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testDeleteTodo(){
        addTodo("satu");
        addTodo("dua");
        addTodo("tiga");

        var result = deleteTodo(20);
        System.out.println(result);

        result = deleteTodo(7);
        System.out.println(result);

        result = deleteTodo(2);
        System.out.println(result);

        showTodo();
    }

    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Nama");
        System.out.println("Hi " + name);

        var channel = input("channel");
        System.out.println(channel);
    }

    /**
     * Menampilkan Halaman Todolist
     */
    public static void viewShowTodo(){
        while (true) {
            showTodo();

            System.out.println("Menu : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");
            if (input.equals("1")) {
                viewAddTodo();
            } else if (input.equals("2")) {
                viewDeleteTodo();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak ada");
            }
        }
    }

    public static void testViewShowTodo(){
        addTodo("satu");
        addTodo("dua");
        addTodo("tiga");
        addTodo("empat");
        viewShowTodo();
    }

    /**
     * menampilkan halaman tambah todolist
     */
    public static void viewAddTodo(){
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("todo (x jika batal)");

        if (todo.equals("x")){
            //batal
        } else {
            addTodo(todo);
        }
    }

    public static void testViewAddTodo(){
        addTodo("satu");
        addTodo("dua");
        viewAddTodo();

        showTodo();
    }

    /**
     * menampilkan halaman delete todolist
     */
    public static void viewDeleteTodo(){
        System.out.println("MENGHAPUS TODO");

        var number = input("Nomor yang di hapus (x jika batal)");

        if (number.equals("x")){
            //batal
        } else {
            boolean success = deleteTodo(Integer.valueOf(number));
            if (!success){
                System.out.println("gagal menghapus todolist :" + number);
            }
        }
    }

    public static void testViewDelete(){
        addTodo("satu");
        addTodo("dua");
        addTodo("tiga");
        showTodo();

        viewDeleteTodo();

        showTodo();
    }
}
