package json_model;

import java.util.Objects;

public class Geo{
    private String lat;
    private String lng;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Geo geo = (Geo) o;
        return Objects.equals(lng, geo.lng) && Objects.equals(lat, geo.lat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lng, lat);
    }
}
