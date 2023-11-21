package org.example.atl;

import java.util.*;

public class CommissionV2 {
    private final List<List<String>> cumulativeVote;
    public CommissionV2(List<List<String>> cumulativeVote) {
       this.cumulativeVote = cumulativeVote;
    }



    public Map<String, VoteSummary> summarize(List<List<String>> cumulativeVote) {
        Map<String, VoteSummary> summary = new HashMap<>();
        for (List<String> vote: cumulativeVote)
        {
            int i = 0;
            for (String cand : vote) {
                summary.computeIfAbsent(cand,x-> new VoteSummary(cand)).updateVote(i);
                i++;
            }
        }
        return summary;
    }

    static class VoteSummary implements Comparable<VoteSummary> {
        public String getCandidate() {
            return candidate;
        }

        private final String candidate;
        int totalVotes;

        public VoteSummary(String candidate) {
            this.candidate = candidate;
        }
        public int getFirstPreference() {
            return firstPreference;
        }

        public int getSecondPreference() {
            return secondPreference;
        }

        int firstPreference;
        int secondPreference;

        public int getTotalVotes() {
            return totalVotes;
        }

        public void updateVote(int preference) {
            this.totalVotes++;
            if (preference==0) {
                this.firstPreference++;
            } else {
                this.secondPreference++;
            }
        }



        @Override
        public int compareTo(VoteSummary o) {
            if (this.totalVotes > o.totalVotes ) {
                return 1;
            } else if (this.totalVotes==o.totalVotes) {
                return Integer.compare(this.secondPreference,o.secondPreference);
            } else {
                return -1;
            }
        }
    }
}
