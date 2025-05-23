public interface Rateable {
    void addRating(int stars);  // 1-5 only
    double getAverageRating();
}
