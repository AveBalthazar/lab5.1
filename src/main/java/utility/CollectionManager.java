package utility;

import data.StudyGroup;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;

public interface CollectionManager {
    public int getFreeNumberForId();

    public ArrayList<StudyGroup> getStudyGroupCollection();

    public void saveTimeCollection();

    public LocalDateTime getLastInitTime();

    public LocalDateTime getSaveTimeCollection();

    public void loadCollection(FileManager fileManager);

    public void clear();

    public void addStringStudyGroupCollection(String[] stringStudyGroup);
}
