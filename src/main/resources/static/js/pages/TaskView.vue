<template>
    <div>
        <task-table/>
    </div>
</template>

<script>
    import TaskTable from 'components/task/TaskTable.vue'

    export default {
        components: {
            TaskTable
        },
        render: function (h) {
            return h(this);
        }
    }
</script>
