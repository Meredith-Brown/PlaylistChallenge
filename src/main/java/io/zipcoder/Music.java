package io.zipcoder;

import java.util.ArrayList;

public class Music {

    private String[] playList;

    public Music(String[] playList){
        this.playList = playList;
    }

    public Integer selection(Integer startIndex, String selection){
        Integer lowerCount = 0;

        // calculate forward
        ArrayList<String> forwardList = new ArrayList<String>();
        for (int i = startIndex; i < playList.length; i++) {
            forwardList.add(playList[i]);
        }
        for (int l = 0; l < startIndex; l++) {
            forwardList.add(playList[l]);
        }
        Integer forwardCount = calculateCount(forwardList, selection);

        // calculate backward
        ArrayList<String> backwardList = new ArrayList<String>();
        for (int k = startIndex; k >= 0; k--) {
            backwardList.add(playList[k]);
        }
        for (int m = backwardList.size() - 1; m > startIndex; m--) {
            backwardList.add(playList[m]);
        }
        Integer backwardCount = calculateCount(backwardList, selection);

        // assess which count is lower
        if (forwardCount < backwardCount) {
            lowerCount = forwardCount;
        } else if (forwardCount > backwardCount) {
            lowerCount = backwardCount;
        } else if (forwardCount == backwardCount) {
            lowerCount = forwardCount;
        }

        return lowerCount;
    }

    public Integer calculateCount(ArrayList<String> arrayList, String selectionToSearchFor) {
        int count = 0;
        for (int j = 0; j < arrayList.size(); j++) {
            String toCompare = arrayList.get(j);
            if (toCompare.equals(selectionToSearchFor)) {
                break;
            } else {
                count += 1;
            }
        }
        return count;
    }
}
