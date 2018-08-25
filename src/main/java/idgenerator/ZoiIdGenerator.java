package idgenerator;

import org.apache.commons.lang.StringUtils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ZoiIdGenerator implements IdGenerator {
    public static final String ZOI_ID_PREFIX = "#dloc_zoi_id_";
    public static final int MAX_ID_NUM = 999999;
    private List<String> currentIds;

    public String generateId(List<String> currentIds) {
        this.currentIds = currentIds;
        List<Integer> idsSorted = this.currentIds.stream().filter(id -> id.startsWith(ZOI_ID_PREFIX) && id.length() == 19)
                .sorted(Comparator.reverseOrder())
                .map(anId -> {
                    String numberPart = anId.substring(anId.length() - 6);
                    return Integer.valueOf(numberPart);
                }).collect(Collectors.toList());
        if (!idsSorted.isEmpty()) {
            int newIdNum = idsSorted.get(0) + 1;
            if (newIdNum > MAX_ID_NUM) {
                newIdNum = getAvailableNumFromZero(idsSorted);
            }
            return ZOI_ID_PREFIX + StringUtils.leftPad(String.valueOf(newIdNum), 6, '0');
        }
        return ZOI_ID_PREFIX + "000000";
    }

    /**
     *
     * @param idsSorted ids sorted in descending order. It is not suppose to be full list form 0 to 999999
     * @return
     */
    private int getAvailableNumFromZero(List<Integer> idsSorted) {
        if (idsSorted.isEmpty() || idsSorted.get(idsSorted.size() - 1) != 0) {
            return 0;
        }
        int newIdNum = 0;
        for (int i = idsSorted.size() - 1; i >= 0 ; i--) {
            Integer currentId = idsSorted.get(i);
            if (!currentId.equals(idsSorted.get(i - 1) - 1)) {
                newIdNum = currentId + 1;
                break;
            }
        }
        return newIdNum;
    }
}
