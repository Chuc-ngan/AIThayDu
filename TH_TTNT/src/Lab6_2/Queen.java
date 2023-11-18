package Lab6_2;

public class Queen {
	private int row;
	private int column;

	public Queen(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	public void move() {
		if(row==Node.N-1) row =0;
		row++;
	}

	// check whether this Queen can attack the given Queen (q)
	public boolean isConflict(Queen q) {
		return this.row == q.row || this.column ==q.column || Math.abs(this.row-q.row)==Math.abs(this.column-q.column);
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "(" + row + ", " + column + ")";
	}
}
