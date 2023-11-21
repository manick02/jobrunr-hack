package org.example.atl;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CandidateVoteWithMultiplePreferencesTest {
    @Test
    public void testSummary() {
        List<String> vote1 = Arrays.asList("C1", "C2");
        List<String> vote2 = Arrays.asList("C3", "C2");
        List<List<String>> cumulativeVote = Arrays.asList(vote1, vote2);
        CommissionV2 commission = new CommissionV2(cumulativeVote);
        Map<String, CommissionV2.VoteSummary> summarize = commission.summarize(cumulativeVote);
        assertEquals(2, summarize.get("C2").getTotalVotes());
        assertEquals(1, summarize.get("C1").getTotalVotes());

        assertEquals(1, summarize.get("C3").getTotalVotes());
        List<CommissionV2.VoteSummary> collect = summarize.values().stream().sorted().collect(Collectors.toList());
       assertEquals("C2",collect.get(2).getCandidate());
    }

}