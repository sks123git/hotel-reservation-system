public class Hotels {
String name;
String rating;
int regularWeekendRates;
int regularWeekdayRates;
int rewardWeekendRates;
int rewardWeekdayRates;


    public Hotels(String name, String rating, int regularWeekendRates, int regularWeekdayRates, int rewardWeekendRates, int rewardWeekdayRates) {
        this.name = name;
        this.rating = rating;
        this.regularWeekendRates = regularWeekendRates;
        this.regularWeekdayRates = regularWeekdayRates;
        this.rewardWeekendRates = rewardWeekendRates;
        this.rewardWeekdayRates = rewardWeekdayRates;
    }

    public Hotels(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getRegularWeekendRates() {
        return regularWeekendRates;
    }

    public void setRegularWeekendRates(int regularWeekendRates) {
        this.regularWeekendRates = regularWeekendRates;
    }

    public int getRegularWeekdayRates() {
        return regularWeekdayRates;
    }

    public void setRegularWeekdayRates(int regularWeekdayRates) {
        this.regularWeekdayRates = regularWeekdayRates;
    }

    public int getRewardWeekendRates() {
        return rewardWeekendRates;
    }

    public void setRewardWeekendRates(int rewardWeekendRates) {
        this.rewardWeekendRates = rewardWeekendRates;
    }

    public int getRewardWeekdayRates() {
        return rewardWeekdayRates;
    }

    public void setRewardWeekdayRates(int rewardWeekdayRates) {
        this.rewardWeekdayRates = rewardWeekdayRates;
    }

    @Override
    public String toString()
    {
        return this.name+"  ("+this.rating+" star)";
    }
}
