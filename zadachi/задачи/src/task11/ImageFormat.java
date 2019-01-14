package task11;

public enum ImageFormat {

    //типы изображений
    PNG(0),JPEG(1),PSD(2),GYF(3);

    //поле
    private int id;

    //конструктор
    ImageFormat(int id) {
        this.id = id;
    }

    //получение типа
    public String getType(){
        switch(id){
            case 0: return ".png";
            case 1: return ".jpeg";
            case 2: return ".psd";
            case 3: return ".gyf";
        }
        return null;
    }

    //получение информации о потерях
    public String getInfo(){
        switch (id) {
            case 0: return "без потери";
            case 1: return "с потерей";
            case 2: return "без потери";
            case 3: return "с огромной потерей";
        }
        return null;
    }

    public static void main(String[] args) {
        for (int i =0; i<ImageFormat.values().length; ++i){
            System.out.println(ImageFormat.values()[i].getType()+": " + ImageFormat.values()[i].getInfo()); //выводим информацию
        }
    }
}
