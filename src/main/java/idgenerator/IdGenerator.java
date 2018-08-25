package idgenerator;

import java.util.ArrayList;
import java.util.List;

public interface IdGenerator {
    String generateId(List<String> currentIds);
}
