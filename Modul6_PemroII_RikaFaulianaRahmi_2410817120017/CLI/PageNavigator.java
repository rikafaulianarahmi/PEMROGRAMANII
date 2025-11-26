package CLI;

class PageNavigator {
    private java.util.HashMap<String, Page> pages;
    private String currentPageKey;

    public PageNavigator() {
        this.pages = new java.util.HashMap<>();
        this.currentPageKey = "main";
    }

    public void registerPage(String key, Page page) {
        pages.put(key, page);
    }

    public void navigateTo(String pageKey) {
        if (pages.containsKey(pageKey)) {
            currentPageKey = pageKey;
        }
    }

    public Page getCurrentPage() {
        return pages.get(currentPageKey);
    }

    public String getCurrentPageKey() {
        return currentPageKey;
    }
}

