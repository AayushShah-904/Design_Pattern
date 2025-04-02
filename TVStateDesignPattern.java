interface OperationState {
    void pressOnButton(TVclass tv);

    void pressOffButton(TVclass tv);

    void pressMuteButton(TVclass tv);
}

class OperationOn implements OperationState {
    public void pressOnButton(TVclass tv) {
        System.out.println("TV is Switched ON ");
        System.out.println("current state is ON");
    }

    public void pressOffButton(TVclass tv) {
        System.out.println("TV is Switched OFF");
        System.out.println("current state is OFF");
        tv.setState(new OperationOff());
    }

    public void pressMuteButton(TVclass tv) {
        System.out.println("TV is Mute");
        System.out.println("current state is MUTE");
        tv.setState(new OperationMute());
    }
}

class OperationOff implements OperationState {
    public void pressOnButton(TVclass tv) {
        System.out.println("TV is Switched ON");
        System.out.println("current state is ON");
        tv.setState(new OperationOn());
    }

    public void pressOffButton(TVclass tv) {
        System.out.println("TV is Switched OFF ");
        System.out.println("current state is OFF");
        
    }

    public void pressMuteButton(TVclass tv) {
        System.out.println("TV is Off, can not mute");
        System.out.println("current state is OFF");
       
    }
}

class OperationMute implements OperationState {
    public void pressOnButton(TVclass tv) {
        System.out.println("TV is Switched ON");
        System.out.println("current state is ON");
        tv.setState(new OperationOn());
    }

    public void pressOffButton(TVclass tv) {
        System.out.println("TV is Switched OFF");
        System.out.println("current state is OFF");
        tv.setState(new OperationOff());
    }

    public void pressMuteButton(TVclass tv) {
        System.out.println("TV is UnMute ");
        System.out.println("current state is MUTE");
        tv.setState(new OperationMute());

    }
}

class TVclass {
    private OperationState state;

    public TVclass() {
        this.state = new OperationOff();
    }

    public void pressOnButton() {
        state.pressOnButton(this);
    }

    public void pressOffButton() {
        state.pressOffButton(this);
    }

    public void pressMuteButton() {
        state.pressMuteButton(this);
    }

    public void setState(OperationState state) {
        this.state = state;
    }

}

public class TVStateDesignPattern {
    public static void main(String[] args) {

        TVclass tv = new TVclass();

        tv.pressOffButton();
        System.out.println(" ");
        tv.pressOnButton();
        System.out.println(" ");
        tv.pressMuteButton();
        System.out.println(" ");
        tv.pressOnButton();
        System.out.println(" ");
        tv.pressOffButton();
        System.out.println(" ");
        tv.pressMuteButton();
        System.out.println(" ");
        tv.pressOnButton();
        System.out.println(" ");
        tv.pressMuteButton();
        System.out.println(" ");
        tv.pressMuteButton();
        System.out.println(" ");


    }
}