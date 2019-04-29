public class Player {
    private String name;
    protected Piece piece;

    public Player(String name) {
        this.name = name;
        this.piece = Piece.takePiece();
    }

    public void takeTurn(Die[] dice) {
        int total = 0;
        for (Die die : dice) {
            die.roll();
            total += die.faceValue;
        }
        System.out.println(name + "got a " + dice[0].getFaceValue() + " and a " + dice[1].getFaceValue() + "\n");

        Square oldLocation = piece.getLocation();
        Square newLocation = Board.getInstance().getSquare(oldLocation, total);

        piece.setLocation(newLocation);

        System.out.println(name + " is now on : " + piece.getLocation());
    }

}