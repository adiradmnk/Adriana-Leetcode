package LatihanUASDDP2.Praktikum5;
import java.util.ArrayList;


// menyimpan process ke dalam struktur penyimpanan queue
class ProcessQueue {
    private ArrayList<Object> list = new ArrayList<>();// ini untuk menyimpan 

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public Object peek() {
        return list.get(0);
    }

    // mengambil process dan menhapusnya dari array
    public Object dequeue() {
        Object o = list.get(0);
        list.remove(0);
        return o;
    }
    
    // masukkan elemen ke dalam queue
    public void enqueue(Object o) {
        list.add(o);
    }
}

// parent class, Sebuah sistem operasi bertanggung jawab untuk mengatur penjadwalan proses yang akan dieksekusi oleh CPU.
class Process {
    protected int pid; // ini adalah kode unik
    protected String processName; // nama process yang sedang dijalankan 

    public Process(int pid, String processName) {
        this.pid = pid;
        this.processName = processName;
    }

    public void execute() { // ini bakal di override untuk menghasilkan perilaku yang berbeda
        System.out.println("Running generic process: " + processName);
    }

    public String toString() { 
        return "PID=" + pid + ", Name=" + processName;
    }
}

// salah satu jenis process bahwa proses sistem
class SystemProcess extends Process {
    public SystemProcess(int pid, String processName) {
        super(pid, processName);
    }

    public void execute() {
        System.out.println("Running System process: " + processName);
    }
}

// menampilkan pesan bahwa proses user sedang dijalankan
class UserProcess extends Process {
    public UserProcess(int pid, String processName) {
        super(pid, processName);
    }
    public void execute() {
        System.out.println("Running User process: " + processName);
    }
}

// menampilkan pesan bahwa proses I/O sedang berjalan
class IOProcess extends Process {
    public IOProcess(int pid, String processName) {
        super(pid, processName);
    }
    public void execute() {
        System.out.println("Running IO process: " + processName);
    }
}

class SimpleOS {
    private ProcessQueue queue = new ProcessQueue();

    public void addProcess(Process p) {
        queue.enqueue(p);
    }

    public void runScheduler() {
        while (!queue.isEmpty()) {
          Object n = queue.dequeue(); 
          Process m = (Process) n;
          m.execute();
        }
    }

    public int getProcessCount() {
        return queue.getSize();
    }

    public Process peekFrontProcess() {
        return (Process) queue.peek();
    }
}

public class SimpleOSApp {
    public static void main(String[] args) {
        SimpleOS os = new SimpleOS();
        os.addProcess(new SystemProcess(1, "Kernel"));
        os.addProcess(new UserProcess(2, "Editor"));
        os.addProcess(new IOProcess(3, "Disk"));
        os.addProcess(new UserProcess(4, "Browser"));
        System.out.println("Total processes: " + os.getProcessCount());
        System.out.println("Front process: " + os.peekFrontProcess());
        System.out.println("\nRunning scheduler...");
        os.runScheduler();
        System.out.println("\nAll processes finished.");
    }
}