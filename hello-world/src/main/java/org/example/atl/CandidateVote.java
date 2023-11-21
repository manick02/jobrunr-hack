package org.example.atl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class CandidateVote {


    static class Vote {
        private String candidate;

        public String getCandidate() {
            return candidate;
        }

        public Vote(String candidate) {
            this.candidate = candidate;
        }
    }

    static class Commission {

        private final List<Vote> votes;

        public Commission(List<Vote> votes) {
            this.votes = votes;
        }

        public String getWinner() {
            Map<String, Long> collect =
                    this.votes.stream().collect(groupingBy(Vote::getCandidate, counting()));
            Optional<Map.Entry<String, Long>> max = collect.entrySet().stream().collect(maxBy(Map.Entry.comparingByValue()));
            return max.isPresent() ? max.get().getKey() : "";
        }
    }
}
