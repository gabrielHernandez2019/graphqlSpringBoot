package com.globallogic.graphql.record;

import java.util.List;

public record EpisodeRecord(int id, String name,String air_date, String episode, List<String> characters, List<String> url, String created) {

}
