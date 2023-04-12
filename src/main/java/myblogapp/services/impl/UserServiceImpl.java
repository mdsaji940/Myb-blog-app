package myblogapp.services.impl;

import myblogapp.entity.User;
import myblogapp.exceptions.ResourceNotFoundException;
import myblogapp.payloads.UserDto;
import myblogapp.repository.UserRepository;
import myblogapp.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepo;

    private ModelMapper mapper;

    public UserServiceImpl(UserRepository userRepo, ModelMapper mapper) {
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        // convert dto to user entity
        User user = this.mapToUser(userDto);
        User newUser = userRepo.save(user);

        // convert user entity to dto
        UserDto dto = this.mapToDto(newUser);
        return dto;
    }

    @Override
    public UserDto updateUser(UserDto userDto, long userId) {

        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User updatedUser = userRepo.save(user);

        // convert user to dto
        UserDto updatedDto = this.mapToDto(updatedUser);

        return updatedDto;
    }

    @Override
    public UserDto getUserById(long userId) {

        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
        UserDto dto = this.mapToDto(user);
        return dto;
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<User> users = userRepo.findAll();
        List<UserDto> userDtos = users.stream().map(user -> mapToDto(user)).collect(Collectors.toList());

        return userDtos;
    }

    @Override
    public void deleteUser(long userId) {

        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
        userRepo.delete(user);
    }

    // convert dto to User
    public User mapToUser(UserDto dto){
        User user = mapper.map(dto, User.class);

//        User user = new User();
//        user.setId(dto.getId());
//        user.setName(dto.getName());
//        user.setEmail(dto.getEmail());
//        user.setPassword(dto.getPassword());
//        user.setAbout(dto.getAbout());
        return user;
    }

    // convert user to dto
    public UserDto mapToDto(User user){
        UserDto dto = mapper.map(user, UserDto.class);

//        UserDto dto = new UserDto();
//        dto.setId(user.getId());
//        dto.setName(user.getName());
//        dto.setEmail(user.getEmail());
//        dto.setPassword(user.getPassword());
//        dto.setAbout(user.getAbout());
        return dto;
    }
}
