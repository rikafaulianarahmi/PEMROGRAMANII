package CLI;

class DataStore {
    private java.util.ArrayList<String> dataList;

    public DataStore() {
        this.dataList = new java.util.ArrayList<>();
    }

    public void addData(String data) {
        dataList.add(data);
    }

    public java.util.ArrayList<String> getAllData() {
        return new java.util.ArrayList<>(dataList);
    }

    public boolean isEmpty() {
        return dataList.isEmpty();
    }
}
