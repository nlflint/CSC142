/**
 * Created by nate on 1/27/14.
 */
public class Application {
    public static void main(String[] args)
    {
        SnowmanIII frosty = new SnowmanIII(true);
        WitchesHat witchesHat = new WitchesHat();
        frosty.addHat(witchesHat);
        frosty.moveHatBy(10, 5);

        WitchesHat witchesHatForTesting = new WitchesHat();
        TestComponent tester = new TestComponent(witchesHatForTesting);
    }
}
