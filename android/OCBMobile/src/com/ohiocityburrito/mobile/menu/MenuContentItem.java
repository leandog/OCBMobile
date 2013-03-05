package com.ohiocityburrito.mobile.menu;
import static com.ohiocityburrito.mobile.Utils.Strings.isNullOrEmpty;

public class MenuContentItem {

    private final String title;
    private final String description;
    private final String price;

    public MenuContentItem(String title) {
        this(title,null,null);
    }

    public MenuContentItem(String title, String description, String price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getPrice() {
        return price;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MenuContentItem other = (MenuContentItem) obj;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }

    public boolean isHeader() {
        return isNullOrEmpty(price) && isNullOrEmpty(description) ;
    }

}
