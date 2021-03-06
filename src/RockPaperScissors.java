import java.io.IOException;
import com.leapmotion.leap.*;

class RockPaperScissorsListener extends Listener {

    public void onInit(Controller controller) {
        System.out.println("Initialized");
    }

    public void onConnect(Controller controller) {
        System.out.println("Connected");
        controller.enableGesture(Gesture.Type.TYPE_SWIPE);
        controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
        controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
        controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
    }

    public void onDisconnect(Controller controller) {
        //Note: not dispatched when running in a debugger.
        System.out.println("Disconnected");
    }

    public void onExit(Controller controller) {
        System.out.println("Exited");
    }

    public void onFrame(Controller controller) {
        // Get the most recent frame and work out if you're a rock, paper or scissor
        Frame frame = controller.frame();

        if (frame.hands().count() != 1) {
            System.out.println("Get your hand ready!");
            return;
        }

        // Countdown to prepare user
        for (int i = 3; i > 0; i--) {
            try {
                System.out.println(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // There will only ever be one hand, so rightmost will work... (still not nice)
        Hand hand = frame.hands().rightmost();
        int extendedFingerCount = 0;

        for (Finger finger : hand.fingers()) {
            if (finger.isExtended()) {
                extendedFingerCount++;
            }
        }

        GestureType userGestureType;
        GestureType computerGestureType = GestureType.values()[(int) Math.floor((Math.random() * 3))];

        // Is this logic sound? Not really, but in practise it is most effective
        if (extendedFingerCount == 0) {
            userGestureType = GestureType.ROCK;
        } else if (extendedFingerCount == 5) {
            userGestureType = GestureType.PAPER;
        } else {
            userGestureType = GestureType.SCISSORS;
        }

        System.out.println("User chooses " + userGestureType.toString() + "!");
        System.out.println("Computer chooses " + computerGestureType.toString() + "!");

        if (userGestureType == computerGestureType) {
            System.out.println("It's a draw!");
        } else if ((userGestureType == GestureType.ROCK && computerGestureType == GestureType.SCISSORS) ||
                (userGestureType ==  GestureType.PAPER && computerGestureType == GestureType.ROCK) ||
                (userGestureType == GestureType.SCISSORS && computerGestureType == GestureType.PAPER)) {
            System.out.println("User wins!");
        } else {
            System.out.println("Computer wins!");
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class RockPaperScissors {
    public static void main(String[] args) {
        // Create a listener and controller
        RockPaperScissorsListener rockPaperScissorsListener = new RockPaperScissorsListener();
        Controller controller = new Controller();

        // Have the rockPaperScissorsListener receive events from the controller
        controller.addListener(rockPaperScissorsListener);

        // Keep this process running until Enter is pressed
        System.out.println("Press Enter to quit...");

        // Diagnostics
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Remove the listener when done
        controller.removeListener(rockPaperScissorsListener);
    }
}
