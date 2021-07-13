<script lang="ts">
    import GruntList from "./GruntList.svelte";
    import Search from "./Search.svelte";
    import Menu from "./Menu.svelte";
    import NewGruntBox from "./NewGruntBox.svelte";

    let visible = true;

    let count: number = 0;
    $: doubled = count * 2;

    function handleClick() {
        ++count;
        visible = !visible;
    }

</script>

<div id="main">
    <div id="top">
        this is the toolbar
    </div>
    <div id="left-panel">
        <nav>
            <Menu/>
        </nav>
        <button on:click={handleClick}>
            Clicked {count} {count === 1 ? 'time' : 'times'} (&times;2 is {doubled})
        </button>
    </div>

    <div id="middle-panel">
        <NewGruntBox/>
        <GruntList/>
    </div>

    <div id="right-panel">
        <Search/>
    </div>
</div>


<style>
    #main {
        display: grid;
        grid-template-columns: auto 50% auto;
        height: 100%;
    }

    #top {
        grid-column: 1 / 4;
        text-align: center;
        position: sticky;
        top: 0;
        background: cadetblue;
        padding-top: 0.5rem;
        padding-bottom: 0.5rem;
    }

    #left-panel {
        justify-self: right;
        padding-right: 2em;
    }

    #middle-panel {
        border-left: solid;
        border-right: solid;
        height: 100%;
    }

    #right-panel {
        padding-left: 10px;
        justify-content: left;
    }

</style>



