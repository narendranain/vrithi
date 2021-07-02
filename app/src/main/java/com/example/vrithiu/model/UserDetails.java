package com.example.vrithiu.model;

import java.util.Date;
import java.util.List;

public class UserDetails {
    // import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString), Root.class); */
    public class Location{
        public String summary;
        public String full;

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getFull() {
            return full;
        }

        public void setFull(String full) {
            this.full = full;
        }
    }

    public class DrinkingV1{
        public int id;
        public String name;
        public String name_alias;
    }

    public class MaritalStatusV1{
        public int id;
        public String name;
        public boolean preference_only;
    }

    public class SmokingV1{
        public int id;
        public String name;
        public String name_alias;
    }

    public class SunSignV1{
        public int id;
        public String name;
    }

    public class MotherTongue{
        public int id;
        public String name;
    }

    public class Faith{
        public int id;
        public String name;
    }

    public class GeneralInformation{
        public String date_of_birth;
        public String date_of_birth_v1;
        public Location location;
        public String drinking;
        public DrinkingV1 drinking_v1;
        public String first_name;
        public String gender;
        public String marital_status;
        public MaritalStatusV1 marital_status_v1;
        public String ref_id;
        public String smoking;
        public SmokingV1 smoking_v1;
        public String sun_sign;
        public SunSignV1 sun_sign_v1;
        public MotherTongue mother_tongue;
        public Faith faith;
        public int height;
        public Object cast;
        public Object kid;
        public Object diet;
        public Object politics;
        public Object pet;
        public Object settle;
        public int age;
    }

    public class Photo{
        public String photo;
        public int photo_id;
        public boolean selected;
        public String status;
    }

    public class IndustryV1{
        public int id;
        public String name;
        public boolean preference_only;
    }

    public class ExperienceV1{
        public int id;
        public String name;
        public String name_alias;
    }

    public class HighestQualificationV1{
        public int id;
        public String name;
        public boolean preference_only;
    }

    public class FieldOfStudyV1{
        public int id;
        public String name;
    }

    public class Work{
        public String industry;
        public IndustryV1 industry_v1;
        public Object monthly_income_v1;
        public String experience;
        public ExperienceV1 experience_v1;
        public String highest_qualification;
        public HighestQualificationV1 highest_qualification_v1;
        public String field_of_study;
        public FieldOfStudyV1 field_of_study_v1;
    }

    public class PreferenceQuestion{
        public String first_choice;
        public String second_choice;
    }

    public class Preference{
        public int answer_id;
        public int id;
        public int value;
        public PreferenceQuestion preference_question;
        public String answer;
        public String first_choice;
        public String second_choice;
    }

    public class ProfileDataList{
        public String question;
        public List<Preference> preferences;
        public String invitation_type;

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public List<Preference> getPreferences() {
            return preferences;
        }

        public void setPreferences(List<Preference> preferences) {
            this.preferences = preferences;
        }

        public String getInvitation_type() {
            return invitation_type;
        }

        public void setInvitation_type(String invitation_type) {
            this.invitation_type = invitation_type;
        }
    }

    public class Profile{
        public GeneralInformation general_information;
        public double approved_time;
        public List<Photo> photos;
        public List<Object> user_interests;
        public Work work;
        public List<Preference> preferences;
        public Object instagram_images;
        public Date last_seen_window;
        public boolean is_facebook_data_fetched;
        public Object icebreakers;
        public Object story;
        public Object meetup;
        public String verification_status;
        public Object latest_poll;
        public Object poll_info;
        public boolean has_active_subscription;
        public boolean show_concierge_badge;
        public String lat;
        public String lng;
        public String last_seen;
        public int online_code;
        public List<ProfileDataList> profile_data_list;
        public String first_name;
        public String avatar;

        public GeneralInformation getGeneral_information() {
            return general_information;
        }

        public void setGeneral_information(GeneralInformation general_information) {
            this.general_information = general_information;
        }

        public double getApproved_time() {
            return approved_time;
        }

        public void setApproved_time(double approved_time) {
            this.approved_time = approved_time;
        }

        public List<Photo> getPhotos() {
            return photos;
        }

        public void setPhotos(List<Photo> photos) {
            this.photos = photos;
        }

        public List<Object> getUser_interests() {
            return user_interests;
        }

        public void setUser_interests(List<Object> user_interests) {
            this.user_interests = user_interests;
        }

        public Work getWork() {
            return work;
        }

        public void setWork(Work work) {
            this.work = work;
        }

        public List<Preference> getPreferences() {
            return preferences;
        }

        public void setPreferences(List<Preference> preferences) {
            this.preferences = preferences;
        }

        public Object getInstagram_images() {
            return instagram_images;
        }

        public void setInstagram_images(Object instagram_images) {
            this.instagram_images = instagram_images;
        }

        public Date getLast_seen_window() {
            return last_seen_window;
        }

        public void setLast_seen_window(Date last_seen_window) {
            this.last_seen_window = last_seen_window;
        }

        public boolean isIs_facebook_data_fetched() {
            return is_facebook_data_fetched;
        }

        public void setIs_facebook_data_fetched(boolean is_facebook_data_fetched) {
            this.is_facebook_data_fetched = is_facebook_data_fetched;
        }

        public Object getIcebreakers() {
            return icebreakers;
        }

        public void setIcebreakers(Object icebreakers) {
            this.icebreakers = icebreakers;
        }

        public Object getStory() {
            return story;
        }

        public void setStory(Object story) {
            this.story = story;
        }

        public Object getMeetup() {
            return meetup;
        }

        public void setMeetup(Object meetup) {
            this.meetup = meetup;
        }

        public String getVerification_status() {
            return verification_status;
        }

        public void setVerification_status(String verification_status) {
            this.verification_status = verification_status;
        }

        public Object getLatest_poll() {
            return latest_poll;
        }

        public void setLatest_poll(Object latest_poll) {
            this.latest_poll = latest_poll;
        }

        public Object getPoll_info() {
            return poll_info;
        }

        public void setPoll_info(Object poll_info) {
            this.poll_info = poll_info;
        }

        public boolean isHas_active_subscription() {
            return has_active_subscription;
        }

        public void setHas_active_subscription(boolean has_active_subscription) {
            this.has_active_subscription = has_active_subscription;
        }

        public boolean isShow_concierge_badge() {
            return show_concierge_badge;
        }

        public void setShow_concierge_badge(boolean show_concierge_badge) {
            this.show_concierge_badge = show_concierge_badge;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getLast_seen() {
            return last_seen;
        }

        public void setLast_seen(String last_seen) {
            this.last_seen = last_seen;
        }

        public int getOnline_code() {
            return online_code;
        }

        public void setOnline_code(int online_code) {
            this.online_code = online_code;
        }

        public List<ProfileDataList> getProfile_data_list() {
            return profile_data_list;
        }

        public void setProfile_data_list(List<ProfileDataList> profile_data_list) {
            this.profile_data_list = profile_data_list;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }

    public class Invites{
        public List<Profile> profiles;
        public int totalPages;
        public int pending_invitations_count;

        public List<Profile> getProfiles() {
            return profiles;
        }

        public void setProfiles(List<Profile> profiles) {
            this.profiles = profiles;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public int getPending_invitations_count() {
            return pending_invitations_count;
        }

        public void setPending_invitations_count(int pending_invitations_count) {
            this.pending_invitations_count = pending_invitations_count;
        }
    }

    public class Likes{
        public List<Profile> profiles;
        public boolean can_see_profile;
        public int likes_received_count;

        public List<Profile> getProfiles() {
            return profiles;
        }

        public void setProfiles(List<Profile> profiles) {
            this.profiles = profiles;
        }

        public boolean isCan_see_profile() {
            return can_see_profile;
        }

        public void setCan_see_profile(boolean can_see_profile) {
            this.can_see_profile = can_see_profile;
        }

        public int getLikes_received_count() {
            return likes_received_count;
        }

        public void setLikes_received_count(int likes_received_count) {
            this.likes_received_count = likes_received_count;
        }
    }

    public class Root{
        public Invites invites;
        public Likes likes;

        public Invites getInvites() {
            return invites;
        }

        public void setInvites(Invites invites) {
            this.invites = invites;
        }

        public Likes getLikes() {
            return likes;
        }

        public void setLikes(Likes likes) {
            this.likes = likes;
        }
    }



}
