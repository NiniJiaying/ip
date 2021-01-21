public class Deadline extends Task{
    protected String by;

    public Deadline(int number, String name, String by) {
        super(number, name);
        this.by = by;
    }

    @Override
    public void addTask(int count) throws DukeException {
        if(this.name.equals("")) {
            throw new DukeException("     ☹ OOPS!!! The description of a deadline cannot be empty.");
        } else {
            super.addTask(count);
        }
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by: " + by + ")";
    }
}

