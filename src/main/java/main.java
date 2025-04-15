public class main {
    public static void main(String[] args) {
        Loading loading = new Loading();
        try {
            loading.setVisible(true);
            int time = 2000 ;
            Thread.sleep(time);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        loading.setVisible(false);
        
    }
}
