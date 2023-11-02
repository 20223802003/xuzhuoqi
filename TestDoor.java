import java.util.Scanner;

class Door {
    protected boolean isOpen = false;

    public void openDoor() {
        if (!isOpen) {
            System.out.println("Door opened");
            isOpen = true;
        } else {
            System.out.println("Door already open!");
        }
    }

    public void closeDoor() {
        if (isOpen) {
            System.out.println("Door closed");
            isOpen = false;
        } else {
            System.out.println("Door already closed!");
        }
    }
}

class DoorWithLock extends Door {
    protected boolean isLocked = false;

    @Override
    public void openDoor() {
        if (isLocked) {
            System.out.println("Door is locked and cannot be opened!");
        } else {
            super.openDoor();
        }
    }

    public void lockDoor() {
        if (!isOpen) {
            System.out.println("Open door cannot be locked!");
        } else if (!isLocked) {
            System.out.println("Door locked");
            isLocked = true;
        } else {
            System.out.println("Door already locked");
        }
    }

    public void unlockDoor() {
        if (isLocked) {
            System.out.println("Door unlocked");
            isLocked = false;
        } else {
            System.out.println("Door is not locked");
        }
    }
}

class DoorWithCodeLock extends DoorWithLock {
    private int code;

    public DoorWithCodeLock(int code) {
        this.code = code;
    }

    @Override
    public void lockDoor() {
        if (!isOpen) {
            System.out.println("Open door cannot be locked!");
        } else {
            super.lockDoor();
        }
    }

    @Override
    public void unlockDoor() {
        if (isLocked) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the code");
            int inputCode = input.nextInt();
            input.close();
            if (inputCode == code) {
                System.out.println("Door unlocked");
                isLocked = false;
            } else {
                System.out.println("Invalid code!");
            }
        } else {
            super.unlockDoor();
        }
    }
}

public class TestDoor {
    public static void main(String[] args) {
        DoorWithCodeLock door = new DoorWithCodeLock(1234);
        Scanner input = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Choose option");
            System.out.println("1: OPEN DOOR");
            System.out.println("2: CLOSE DOOR");
            System.out.println("3: LOCK DOOR");
            System.out.println("4: UNLOCK DOOR");
            System.out.println("5: EXIT");
            System.out.println("Enter your option");
            int option = input.nextInt();
            switch (option) {
                case 1:
                    door.openDoor();
                    break;
                case 2:
                    door.closeDoor();
                    break;
                case 3:
                    door.lockDoor();
                    break;
                case 4:
                    door.unlockDoor();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
        input.close();
    }
}