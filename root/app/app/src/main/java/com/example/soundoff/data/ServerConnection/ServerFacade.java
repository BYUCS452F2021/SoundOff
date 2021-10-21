package com.example.soundoff.data.ServerConnection;

//import android.os.Build;

import com.example.soundoff.service.request.*;
import com.example.soundoff.service.response.*;


/**
 * Acts as a Facade to the Tweeter server. All network requests to the server should go through
 * this class.
 */
//@RequiresApi(api = Build.VERSION_CODES.O)
public class ServerFacade {

    private static final String SERVER_URL = "https://1cqnpkx9qe.execute-api.us-east-1.amazonaws.com/dev"; //TODO: UPDATE URL

    private final ClientCommunicator clientCommunicator = new ClientCommunicator(SERVER_URL);

//    // This is the hard coded followee data returned by the 'getFollowees()' method
////    private static final String MALE_IMAGE_URL = "https://faculty.cs.byu.edu/~jwilkerson/cs340/tweeter/images/donald_duck.png";
////    private static final String FEMALE_IMAGE_URL = "https://faculty.cs.byu.edu/~jwilkerson/cs340/tweeter/images/daisy_duck.png";
////
////    private final User user1 = new User("Allen", "Anderson", MALE_IMAGE_URL);
////    private final User user2 = new User("Amy", "Ames", FEMALE_IMAGE_URL);
////    private final User user3 = new User("Bob", "Bobson", MALE_IMAGE_URL);
////    private final User user4 = new User("Bonnie", "Beatty", FEMALE_IMAGE_URL);
////    private final User user5 = new User("Chris", "Colston", MALE_IMAGE_URL);
////    private final User user6 = new User("Cindy", "Coats", FEMALE_IMAGE_URL);
////    private final User user7 = new User("Dan", "Donaldson", MALE_IMAGE_URL);
////    private final User user8 = new User("Dee", "Dempsey", FEMALE_IMAGE_URL);
////    private final User user9 = new User("Elliott", "Enderson", MALE_IMAGE_URL);
////    private final User user10 = new User("Elizabeth", "Engle", FEMALE_IMAGE_URL);
////    private final User user11 = new User("Frank", "Frandson", MALE_IMAGE_URL);
////    private final User user12 = new User("Fran", "Franklin", FEMALE_IMAGE_URL);
////    private final User user13 = new User("Gary", "Gilbert", MALE_IMAGE_URL);
////    private final User user14 = new User("Giovanna", "Giles", FEMALE_IMAGE_URL);
////    private final User user15 = new User("Henry", "Henderson", MALE_IMAGE_URL);
////    private final User user16 = new User("Helen", "Hopwell", FEMALE_IMAGE_URL);
////    private final User user17 = new User("Igor", "Isaacson", MALE_IMAGE_URL);
////    private final User user18 = new User("Isabel", "Isaacson", FEMALE_IMAGE_URL);
////    private final User user19 = new User("Justin", "Jones", MALE_IMAGE_URL);
////    private final User user20 = new User("Jill", "Johnson", FEMALE_IMAGE_URL);
//
////    private DummyServer dummyServer;
//        private Map<String, String> headers;
//
    public ServerFacade(){
//        dummyServer = DummyServer.getInstance();
//        headers = new HashMap<>();
//        headers.put("Authorization", "fakeAuthToken");
    }

    public AttendanceResponse recordAttendance(AttendanceRequest request){
        return new AttendanceResponse();
    }

    public ClassResponse addClass(ClassRequest request){
        return new ClassResponse();
    }

    public CodeResponse attendanceCode(CodeRequest request){
        return new CodeResponse();
    }

    public EnrollmentResponse enroll(EnrollmentRequest request){
        return new EnrollmentResponse();
    }

    public StudentAttendanceResponse recordAttendance(StudentAttendanceRequest request){
        return new StudentAttendanceResponse();
    }

    public StudentLoginResponse loginStudent(StudentLoginRequest request){
        return new StudentLoginResponse();
    }

    public StudentRegisterResponse registerStudent(StudentRegisterRequest request){
        return new StudentRegisterResponse();
    }

    public StudentsResponse listStudents(StudentsRequest request){
        return new StudentsResponse();
    }

    public TeacherLoginResponse loginTeacher(TeacherLoginRequest request){
        return new TeacherLoginResponse();
    }

    public TeacherRegisterResponse registerTeacher(TeacherRegisterRequest request){
        return new TeacherRegisterResponse();
    }


//    /**
//     * Performs a login and if successful, returns the logged in user and an auth token. The current
//     * implementation is hard-coded to return a dummy user and doesn't actually make a network
//     * request.
//     *
//     * @param request contains all information needed to perform a login.
//     * @return the login response.
//     */
//    public LoginResponse login(LoginRequest request) throws IOException, TweeterRemoteException{
//        System.out.print("I am attempting to login");
//        //get user with this username and password.
//
//        // login with the user's info
////        User user = dummyServer.getUserInfo(request.getUsername(), request.getPassword());
//        LoginResponse response = clientCommunicator.doPost("/login",request,null,LoginResponse.class);
////        if (user != null) {
////            return new LoginResponse(user, new AuthToken());
////        } else {
////            return new LoginResponse("Invalid Login");
////        }
//        if(response.isSuccess()) {
//            return response;
//        }
//        else {
//            ///TODO: Maybe throw runtime exception?
//            //@throw new RuntimeException(response.getMessage());
//            return new LoginResponse(response.getMessage());
////            User user = new User("Allen", "Anderson","@user1",
////                    "https://faculty.cs.byu.edu/~jwilkerson/cs340/tweeter/images/donald_duck.png");
////            return new LoginResponse(user, new AuthToken());
//        }
//    }
//
//    /**
//     * Performs a register and if successful, returns the logged in user and an auth token. The current
//     * implementation is hard-coded to return a dummy user and doesn't actually make a network
//     * request.
//     *
//     * @param request contains all information needed to perform a register.
//     * @return the register response.
//     */
//    public LoginResponse register(RegisterRequest request) throws IOException, TweeterRemoteException{
////        User user = new User(request.getFirstName(), request.getLastName(), request.getUsername(),null);
////        user.setImageBytes(request.getImageBytes());
////
////         user = dummyServer.addUser(user, request.getPassword());
////        /// register this user
////        if(user != null){
////            return new LoginResponse(user, new AuthToken());
////        } else {
////            return new LoginResponse("username already in the database");
////        }
//        //return why registration was unsuccessful (e.g. user already has an account with that username)
//        LoginResponse response = clientCommunicator.doPost("/register",request,null,LoginResponse.class);
//        if(response.isSuccess()) {
//            return response;
//        }
//        else {
//            ///TODO: Maybe throw runtime exception?
//            //throw new RuntimeException(response.getMessage());
//            return new LoginResponse("error logging in");
//            //return new LoginResponse(response.getMessage());
////            User user = new User("Allen", "Anderson","@user1",
////                    "https://faculty.cs.byu.edu/~jwilkerson/cs340/tweeter/images/donald_duck.png");
////            return new LoginResponse(user, new AuthToken());
//        }
//
//    }
//
//    public LogoutResponse logout(LogoutRequest request) throws IOException, TweeterRemoteException{
//        //get user with this username and password.
////        return new LogoutResponse(true,null);
//
//        LogoutResponse response = clientCommunicator.doPost("/logout",request,headers,LogoutResponse.class);
//        if(response.isSuccess()) {
//            return response;
//        }
//        else {
//            ///TODO: Maybe throw runtime exception?
//            //throw new RuntimeException(response.getMessage());
//            return new LogoutResponse("Logout unsuccessful");
//            //return new LogoutResponse(false,null);
////            User user = new User("Allen", "Anderson","@user1",
////                    "https://faculty.cs.byu.edu/~jwilkerson/cs340/tweeter/images/donald_duck.png");
////            return new LoginResponse(user, new AuthToken());
//        }
//    }
//
//    public PostResponse post(PostRequest request) throws IOException, TweeterRemoteException{
////        dummyServer.addToStory(request.getPost());
//        /// post to server
//
//        //return why post was unsuccessful
//
////        return new PostResponse(request.getPost());
//        PostResponse response = clientCommunicator.doPost("/post",request,headers,PostResponse.class);
//        if(response.isSuccess()) {
//            return response;
//        }
//        else {
//            ///TODO: Maybe throw runtime exception?
//            //throw new RuntimeException(response.getMessage());
//            if(response.getMessage().equals("this is just a filler for now")){
//                return(new PostResponse(new Post()));
//            }
//            return new PostResponse("error posting");
//            //return new LogoutResponse(false,null);
////            User user = new User("Allen", "Anderson","@user1",
////                    "https://faculty.cs.byu.edu/~jwilkerson/cs340/tweeter/images/donald_duck.png");
////            return new LoginResponse(user, new AuthToken());
//        }
//    }
//
//    public FollowStatusResponse changeFollowStatus(FollowStatusRequest request) throws IOException, TweeterRemoteException {
////        dummyServer.changeFollowStatus(request.getLoggedInUser(), request.getUsername(),request.isToFollow());
//////        //return why post was unsuccessful
//////
//////        return new FollowStatusResponse(request.getLoggedInUser(),!request.isToFollow());
//        FollowStatusResponse response = clientCommunicator.doPost("/changefollowstatus",request,headers,FollowStatusResponse.class);
//        if(response.isSuccess()) {
//            return response;
//        }
//        else {
//            ///TODO: Maybe throw runtime exception?
//            //throw new RuntimeException(response.getMessage());
//            return new FollowStatusResponse("error changing status");
//            //return new LogoutResponse(false,null);
////            User user = new User("Allen", "Anderson","@user1",
////                    "https://faculty.cs.byu.edu/~jwilkerson/cs340/tweeter/images/donald_duck.png");
////            return new LoginResponse(user, new AuthToken());
//        }
//    }
//
//    public UserInfoResponse getUserInfo(UserInfoRequest request) throws IOException, TweeterRemoteException{
////        User user = dummyServer.getUserInfo(request.getUsername(),request.getAuthToken());
////        int followers = dummyServer.getFollowers(user).size();
////        int followees = dummyServer.getFollowees(user).size();
////        boolean currUserFollows = false;
////        if(dummyServer.getFollowers(user).contains(request.getCurrUser())){
////            currUserFollows = true;
////        }
////        return new UserInfoResponse(user,followers,followees,currUserFollows);
//        UserInfoResponse response = clientCommunicator.doPost("/getuserinfo",request,headers,UserInfoResponse.class);
//        if(response.isSuccess()) {
//            return response;
//        }
//        else {
//            ///TODO: Maybe throw runtime exception?
//            //throw new RuntimeException(response.getMessage());
//            return new UserInfoResponse("Error getting info");
//            //return new LogoutResponse(false,null);
////            User user = new User("Allen", "Anderson","@user1",
////                    "https://faculty.cs.byu.edu/~jwilkerson/cs340/tweeter/images/donald_duck.png");
////            return new LoginResponse(user, new AuthToken());
//        }
//
//    }
//
//    /**
//     * Returns the users that the user specified in the request is following. Uses information in
//     * the request object to limit the number of followees returned and to return the next set of
//     * followees after any that were returned in a previous request. The current implementation
//     * returns generated data and doesn't actually make a network request.
//     *
//     * @param request contains information about the user whose followees are to be returned and any
//     *                other information required to satisfy the request.
//     * @return the following response.
//     */
//    public FollowingResponse getFollowees(FollowingRequest request) throws IOException, TweeterRemoteException{
////
////        // Used in place of assert statements because Android does not support them
////        if(BuildConfig.DEBUG) {
////            if(request.getLimit() < 0) {
////                throw new AssertionError();
////            }
////
////            if(request.getFollower() == null) {
////                throw new AssertionError();
////            }
////        }
////
////        List<User> allFollowees = dummyServer.getFollowees(request.getFollower());
////        List<User> responseFollowees = new ArrayList<>(request.getLimit());
////
////        boolean hasMorePages = false;
////
////        if(request.getLimit() > 0) {
////            int followeesIndex = getFolloweesStartingIndex(request.getLastFollowee(), allFollowees);
////
////            for(int limitCounter = 0; followeesIndex < allFollowees.size() && limitCounter < request.getLimit(); followeesIndex++, limitCounter++) {
////                responseFollowees.add(allFollowees.get(followeesIndex));
////            }
////
////            hasMorePages = followeesIndex < allFollowees.size();
////        }
////
////        return new FollowingResponse(responseFollowees, hasMorePages);
//
//        FollowingResponse response = clientCommunicator.doPost("/getfollowing",request,headers,FollowingResponse.class);
//
//         if(response.isSuccess()) {
//            return response;
//        } else {
//            ///TODO: Maybe throw runtime exception?
//            //throw new exception(response.getMessage());
//            return new FollowingResponse(response.getMessage());
//        }
//
//    }
//
//    public FollowerResponse getFollowers(FollowerRequest request)  throws IOException, TweeterRemoteException{
//
//        // Used in place of assert statements because Android does not support them
////        if(BuildConfig.DEBUG) {
////            if(request.getLimit() < 0) {
////                throw new AssertionError();
////            }
////
////            if(request.getFollowee() == null) {
////                throw new AssertionError();
////            }
////        }
////
////        List<User> allFollowers = dummyServer.getFollowers(request.getFollowee());//getDummyFollowees();
////        List<User> responseFollowers = new ArrayList<>(request.getLimit());
////
////        boolean hasMorePages = false;
////
////        if(request.getLimit() > 0) {
////            int followersIndex = getFolloweesStartingIndex(request.getLastFollower(), allFollowers);
////
////            for(int limitCounter = 0; followersIndex < allFollowers.size() && limitCounter < request.getLimit(); followersIndex++, limitCounter++) {
////                responseFollowers.add(allFollowers.get(followersIndex));
////            }
////
////            hasMorePages = followersIndex < allFollowers.size();
////        }
////
////        return new FollowerResponse(responseFollowers, hasMorePages);
//
//        FollowerResponse response = clientCommunicator.doPost("/getfollowers",request,headers,FollowerResponse.class);
//
//        if(response.isSuccess()) {
//            return response;
//        } else {
//            ///TODO: Maybe throw runtime exception?
//            //throw new RuntimeException(response.getMessage());
//            return new FollowerResponse(response.getMessage());
//        }
//    }
//
//    public FeedResponse getFeedPosts(FeedRequest request)  throws IOException, TweeterRemoteException {
//
////        // Used in place of assert statements because Android does not support them
////        //if(BuildConfig.DEBUG) {
////            if(request.getLimit() < 0) {
////                throw new AssertionError();
////            }
////
////            if(request.getFeedUser() == null) {
////                throw new AssertionError();
////            }
////        //}
////
////        List<Post> allPosts = dummyServer.getFeed(request.getFeedUser());//new ArrayList<>();//getDummyFollowees();
////        List<Post> responsePosts = new ArrayList<>(request.getLimit());
////
////        boolean hasMorePages = false;
////
////        if(request.getLimit() > 0) {
////            int postsIndex = getPostStartingIndex(request.getLastPost(), allPosts);
////
////            for(int limitCounter = 0; postsIndex < allPosts.size() && limitCounter < request.getLimit(); postsIndex++, limitCounter++) {
////                responsePosts.add(allPosts.get(postsIndex));
////            }
////
////            hasMorePages = postsIndex < allPosts.size();
////        }
////
//// return new FeedResponse(responsePosts, hasMorePages);
//
////        JsonSerializer serializer = new JsonSerializer();
////        String responseString = "{\"success\":true,\"hasMorePages\":true,\"feedPosts\":[{\"poster\":{\"firstName\":\"Allen\",\"lastName\":\"Anderson\",\"alias\":\"@user1\",\"imageUrl\":\"https://faculty.cs.byu.edu/~jwilkerson/cs340/tweeter/images/donald_duck.png\",\"name\":\"Allen Anderson\"},\"message\":\"@user1 http://www.google.com and other stuff\",\"timeStamp\":61563589320000},{\"poster\":{\"firstName\":\"Amy\",\"lastName\":\"Ames\",\"alias\":\"@user2\",\"imageUrl\":\"https://faculty.cs.byu.edu/~jwilkerson/cs340/tweeter/images/daisy_duck.png\",\"name\":\"Amy Ames\"},\"message\":\"@user1 http://www.google.com and other stuff\",\"timeStamp\":61563589320000},{\"poster\":{\"firstName\":\"Bob\",\"lastName\":\"Bobson\",\"alias\":\"@user3\",\"imageUrl\":\"https://faculty.cs.byu.edu/~jwilkerson/cs340/tweeter/images/donald_duck.png\",\"name\":\"Bob Bobson\"},\"message\":\"@user1 http://www.google.com and other stuff\",\"timeStamp\":61563589320000},{\"poster\":{\"firstName\":\"Bonnie\",\"lastName\":\"Beatty\",\"alias\":\"@user4\",\"imageUrl\":\"https://faculty.cs.byu.edu/~jwilkerson/cs340/tweeter/images/daisy_duck.png\",\"name\":\"Bonnie Beatty\"},\"message\":\"@user1 http://www.google.com and other stuff\",\"timeStamp\":61563589320000},{\"poster\":{\"firstName\":\"Chris\",\"lastName\":\"Colston\",\"alias\":\"@user5\",\"imageUrl\":\"https://faculty.cs.byu.edu/~jwilkerson/cs340/tweeter/images/donald_duck.png\",\"name\":\"Chris Colston\"},\"message\":\"@user1 http://www.google.com and other stuff\",\"timeStamp\":61563589320000}]}\n";
////        FeedResponse testResponse = serializer.deserialize(responseString,FeedResponse.class);
//        FeedResponse response = clientCommunicator.doPost("/getfeedposts",request,headers,FeedResponse.class);
//
//        if(response.isSuccess()) {
//            return response;
//        } else {
//            ///TODO: Maybe throw runtime exception?
//            //throw new RuntimeException(response.getMessage());
//            return new FeedResponse(response.getMessage());
//        }
//    }
//
//    public StoryResponse getStoryPosts(StoryRequest request) throws IOException, TweeterRemoteException {
////
////         //Used in place of assert statements because Android does not support them
////        //if(BuildConfig.DEBUG) {
////            if(request.getLimit() < 0) {
////                throw new AssertionError();
////            }
////
////            if(request.getStoryUser() == null) {
////                throw new AssertionError();
////            }
////        //}
////
////        List<Post> allPosts = dummyServer.getStory(request.getStoryUser());//new ArrayList<>();//getDummyFollowees();
////        List<Post> responsePosts = new ArrayList<>(request.getLimit());
////
////        boolean hasMorePages = false;
////
////        if(request.getLimit() > 0) {
////            int postsIndex = getPostStartingIndex(request.getLastPost(), allPosts);
////
////            for(int limitCounter = 0; postsIndex < allPosts.size() && limitCounter < request.getLimit(); postsIndex++, limitCounter++) {
////                responsePosts.add(allPosts.get(postsIndex));
////            }
////
////            hasMorePages = postsIndex < allPosts.size();
////        }
////
////        return new StoryResponse(responsePosts, hasMorePages);
//        StoryResponse response = clientCommunicator.doPost("/getstoryposts",request,headers,StoryResponse.class);
//
//        if(response.isSuccess()) {
//            return response;
//        } else {
//            ///TODO: Maybe throw runtime exception?
//            //throw new RuntimeException(response.getMessage());
//            return new StoryResponse(response.getMessage());
//        }
//    }
//
////    /**
////     * Determines the index for the first followee in the specified 'allFollowees' list that should
////     * be returned in the current request. This will be the index of the next followee after the
////     * specified 'lastFollowee'.
////     *
////     * @param lastFollowee the last followee that was returned in the previous request or null if
////     *                     there was no previous request.
////     * @param allFollowees the generated list of followees from which we are returning paged results.
////     * @return the index of the first followee to be returned.
////     */
////    private int getFolloweesStartingIndex(User lastFollowee, List<User> allFollowees) {
////
////        int followeesIndex = 0;
////
////        if(lastFollowee != null) {
////            // This is a paged request for something after the first page. Find the first item
////            // we should return
////            for (int i = 0; i < allFollowees.size(); i++) {
////                if(lastFollowee.equals(allFollowees.get(i))) {
////                    // We found the index of the last item returned last time. Increment to get
////                    // to the first one we should return
////                    followeesIndex = i + 1;
////                    break;
////                }
////            }
////        }
////
////        return followeesIndex;
////    }
////
////    private int getPostStartingIndex(Post lastPost, List<Post> allPosts) {
////
////        int postIndex = 0;
////
////        if(lastPost != null) {
////            // This is a paged request for something after the first page. Find the first item
////            // we should return
////            for (int i = 0; i < allPosts.size(); i++) {
////                if(lastPost.equals(allPosts.get(i))) {
////                    // We found the index of the last item returned last time. Increment to get
////                    // to the first one we should return
////                    postIndex = i + 1;
////                    break;
////                }
////            }
////        }
////
////        return postIndex;
////    }
//
////
////    /**
////     * Returns the list of dummy followee data. This is written as a separate method to allow
////     * mocking of the followees.
////     *
////     * @return the generator.
////     */
////    List<User> getDummyFollowees() {
////        return Arrays.asList(user1, user2, user3, user4, user5, user6, user7,
////                user8, user9, user10, user11, user12, user13, user14, user15, user16, user17, user18,
////                user19, user20);
////    }
}
