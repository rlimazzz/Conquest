package Todo;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

class TaskRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Task) {
            Task task = (Task) value;
            setText(task.toString());
        }
        return this;
    }
}
