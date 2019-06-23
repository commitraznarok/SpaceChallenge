public class U1 extends Rocket {

    U1(long cost, int weight) {
        super(cost, weight);
    }

    @Override
    public boolean launch() {
        // return super.launch();
        // Chance of launch explosion = 5% * (cargo carried / cargo limit)
        float launchChancePercentage = 0.05f;
        boolean result;

        float chanceOfLaunchEexplosion = launchChancePercentage * (getWeight() /getMaxWeight());
        result = Math.random() > chanceOfLaunchEexplosion;

        return result;
    }

    @Override
    public boolean land() {
        //return super.land();
        //Chance of landing crash = 1% * (cargo carried / cargo limit)
        float landChancePercentage = 0.01f;
        boolean result;

        float chanceOfLandingCrash = landChancePercentage * (getWeight() / getMaxWeight());
        result = Math.random() > chanceOfLandingCrash;

        return result;
    }

}
