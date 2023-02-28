
struct bounds {
    int min;
    int max;
};
typedef struct bounds bounds;

program RANDOM {
    version VERSION_UN {
        void SET_BOUNDS( bounds ) = 0;
        int NEXT_RANDOM( void ) = 1;
    } = 1;
} = 0x20000001;
